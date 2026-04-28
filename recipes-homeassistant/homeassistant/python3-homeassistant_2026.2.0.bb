SUMMARY = "Open-source home automation platform running on Python 3"
HOMEPAGE = "https://home-assistant.io/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=86d3f3a95c324c9479bd8986968f4327"

HOMEASSISTANT_CONFIG_DIR ?= "${localstatedir}/lib/homeassistant"
HOMEASSISTANT_CONFIG_DIR[doc] = "Configuration directory used by home-assistant."
HOMEASSISTANT_USER ?= "homeassistant"
HOMEASSISTANT_USER[doc] = "User the home-assistent service runs as."

# Fetch from upstream git, pinned to tag 2026.2.0
# https://github.com/home-assistant/core/releases/tag/2026.2.0
SRC_URI = "git://github.com/home-assistant/core.git;protocol=https;nobranch=1 \
           file://0001-Fix-pyproject.toml-for-setuptools-compat.patch \
"
SRCREV = "3e8923f10575096edf81d5da7600201cd7d13256"
PV = "2026.2.0"

S = "${WORKDIR}/git"

inherit python_setuptools_build_meta useradd systemd

USERADD_PACKAGES = "${PN}"
GROUPADD_PARAM:${PN} = "homeassistant"
USERADD_PARAM:${PN} = "\
    --system --home ${HOMEASSISTANT_CONFIG_DIR} \
    --no-create-home --shell /bin/false \
    --groups homeassistant,dialout --gid homeassistant ${HOMEASSISTANT_USER} \
"

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = "homeassistant.service"

do_install:append () {
    install -d ${D}${HOMEASSISTANT_CONFIG_DIR}

    # Install systemd unit files and set correct config directory
    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${THISDIR}/files/homeassistant.service ${D}${systemd_unitdir}/system
    sed -i -e 's,@HOMEASSISTANT_CONFIG_DIR@,${HOMEASSISTANT_CONFIG_DIR},g' ${D}${systemd_unitdir}/system/homeassistant.service
    sed -i -e 's,@HOMEASSISTANT_USER@,${HOMEASSISTANT_USER},g' ${D}${systemd_unitdir}/system/homeassistant.service
}

# Core dependencies for homeassistant 2026.2.0
RDEPENDS:${PN} = "\
    ${PYTHON_PN}-aiodns \
    ${PYTHON_PN}-aiozoneinfo \
    ${PYTHON_PN}-aiohttp \
    ${PYTHON_PN}-aiohttp-cors \
    ${PYTHON_PN}-astral \
    ${PYTHON_PN}-async-interrupt \
    ${PYTHON_PN}-attrs \
    ${PYTHON_PN}-atomicwrites-homeassistant \
    ${PYTHON_PN}-awesomeversion \
    ${PYTHON_PN}-bcrypt \
    ${PYTHON_PN}-certifi \
    ${PYTHON_PN}-ciso8601 \
    ${PYTHON_PN}-cryptography \
    ${PYTHON_PN}-httpx \
    ${PYTHON_PN}-home-assistant-bluetooth \
    ${PYTHON_PN}-ifaddr \
    ${PYTHON_PN}-jinja2 \
    ${PYTHON_PN}-lru-dict \
    ${PYTHON_PN}-pyjwt \
    ${PYTHON_PN}-pillow \
    ${PYTHON_PN}-propcache \
    ${PYTHON_PN}-pyopenssl \
    ${PYTHON_PN}-orjson \
    ${PYTHON_PN}-packaging \
    ${PYTHON_PN}-psutil-home-assistant \
    ${PYTHON_PN}-python-slugify \
    ${PYTHON_PN}-pyyaml \
    ${PYTHON_PN}-requests \
    ${PYTHON_PN}-securetar \
    ${PYTHON_PN}-sqlalchemy \
    ${PYTHON_PN}-typing-extensions \
    ${PYTHON_PN}-ulid-transform \
    ${PYTHON_PN}-urllib3 \
    ${PYTHON_PN}-voluptuous \
    ${PYTHON_PN}-voluptuous-serialize \
    ${PYTHON_PN}-yarl \
    ${PYTHON_PN}-zeroconf \
    \
    ${PYTHON_PN}-statistics \
    ${PYTHON_PN}-sqlite3 \
    ${PYTHON_PN}-core \
"
