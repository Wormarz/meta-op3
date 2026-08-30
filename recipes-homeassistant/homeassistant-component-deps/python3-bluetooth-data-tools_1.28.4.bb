SUMMARY = "Tools for converting bluetooth data and packets"
HOMEPAGE = "https://github.com/Bluetooth-Devices/bluetooth-data-tools"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=732518afbb3ba92dbf606e49f9045cc9"

PYPI_PACKAGE = "bluetooth_data_tools"

SRC_URI[sha256sum] = "0617a879c30e0410c3506e263ee9e9bd51b06d64db13b4ad0bfd765f794b756f"

DEPENDS += "\
    ${PYTHON_PN}-cython-native \
    ${PYTHON_PN}-setuptools-native \
"

# setuptools >= 77.0 required but we have 76.x; skip the check and build with what's available
PEP517_BUILD_OPTS += "--skip-dependency-check"

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-core \
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
