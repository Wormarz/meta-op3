SUMMARY = "A faster version of dbus-next"
HOMEPAGE = "https://github.com/bluetooth-devices/dbus-fast"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=729e372b5ea0168438e4fd4a00a04947"

PYPI_PACKAGE = "dbus_fast"

SRC_URI[sha256sum] = "6c9e1b45e4b5e7df0c021bf1bf3f27649374e47c3de1afdba6d00a7d7bba4b3a"

DEPENDS += "\
    ${PYTHON_PN}-cython-native \
    ${PYTHON_PN}-setuptools-native \
"

PEP517_BUILD_OPTS += "--skip-dependency-check"

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-core \
"

inherit pypi python_setuptools_build_meta python_poetry_core
