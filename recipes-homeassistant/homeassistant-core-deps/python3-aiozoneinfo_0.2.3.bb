SUMMARY = "Async support for zoneinfo"
HOMEPAGE = "https://github.com/bdraco/aiozoneinfo"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9fd9da0eba9bb27343ae47cb3fb6cde8"

PYPI_PACKAGE = "aiozoneinfo"

SRC_URI[sha256sum] = "987ce2a7d5141f3f4c2e9d50606310d0bf60d688ad9f087aa7267433ba85fff3"

RDEPENDS:${PN} += "python3-tzdata"

inherit pypi python_poetry_core
