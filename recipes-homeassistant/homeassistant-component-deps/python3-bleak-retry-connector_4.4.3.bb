SUMMARY = "A connector for bleak that handles Bluetooth service connection issues"
HOMEPAGE = "https://github.com/Bluetooth-Devices/bleak-retry-connector"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d8b5b84f8af09011094cd7c29a9f972c"

PYPI_PACKAGE = "bleak_retry_connector"

SRC_URI[sha256sum] = "70aa305dbd26eaf0586dd24723daac93ee3dd6a465e9782bf02b711fcbc4a527"

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-bleak \
    ${PYTHON_PN}-bluetooth-adapters \
"

inherit pypi python_poetry_core
