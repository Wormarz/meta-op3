SUMMARY = "Bleak is a GATT client software, capable of connecting to BLE devices acting as GATT servers"
HOMEPAGE = "https://github.com/hbldh/bleak"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=bcbc2069a86cba1b5e47253679f66ed7"

PYPI_PACKAGE = "bleak"

SRC_URI[sha256sum] = "4600cc5852f2392ce886547e127623f188e689489c5946d422172adf80635cf9"

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-async-timeout \
    ${PYTHON_PN}-typing-extensions \
"

inherit pypi python_poetry_core
