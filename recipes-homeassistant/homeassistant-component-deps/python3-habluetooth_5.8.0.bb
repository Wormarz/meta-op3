SUMMARY = "High-level Bluetooth integration library for Home Assistant"
HOMEPAGE = "https://github.com/Bluetooth-Devices/habluetooth"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=da57f3e0372e39698a274746eb9d65d6"

PYPI_PACKAGE = "habluetooth"

SRC_URI[sha256sum] = "7ecbe1ad6a4d3610f918dbe573bb9bee16064e7a4a61c95c37ef22b0c4533493"

DEPENDS += "\
    ${PYTHON_PN}-cython-native \
    ${PYTHON_PN}-setuptools-native \
"

PEP517_BUILD_OPTS += "--skip-dependency-check"

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-bleak \
    ${PYTHON_PN}-bleak-retry-connector \
    ${PYTHON_PN}-bluetooth-adapters \
    ${PYTHON_PN}-bluetooth-auto-recovery \
    ${PYTHON_PN}-bluetooth-data-tools \
    ${PYTHON_PN}-dbus-fast \
"

# Fix PEP 639 license format not supported by setuptools < 78
# and relax setuptools version requirement
python do_patch:append() {
    import os
    pyproject = os.path.join(d.getVar('S'), 'pyproject.toml')
    if os.path.exists(pyproject):
        with open(pyproject) as f:
            content = f.read()
        content = content.replace('license = "Apache-2.0"', 'license = {text = "Apache-2.0"}')
        content = content.replace('setuptools>=77.0', 'setuptools>=76.0.0')
        with open(pyproject, 'w') as f:
            f.write(content)
}

inherit pypi python_setuptools_build_meta python_poetry_core
