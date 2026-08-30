SUMMARY = "Enumerate and find Bluetooth adapters"
HOMEPAGE = "https://github.com/Bluetooth-Devices/bluetooth-adapters"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=732518afbb3ba92dbf606e49f9045cc9"

PYPI_PACKAGE = "bluetooth_adapters"

SRC_URI[sha256sum] = "ef7363c7557721fdad28df30fbdf0c7f2f793671ad259b99be4b38a78afe9038"

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-dbus-fast \
"

inherit pypi python_poetry_core
