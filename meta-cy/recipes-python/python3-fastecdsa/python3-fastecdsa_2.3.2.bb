SUMMARY = "A module for fast elliptic curve cryptography"
MAINTAINER = "Rodolfo Giometti <giometti@enneenne.com>"
SECTION = "devel/python"
HOMEPAGE = "https://github.com/AntonKueltz/fastecdsa"
LICENSE = "CC0-1.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7246f848faa4e9c9fc0ea91122d6e680"

DEPENDS += "gmp"

PYPI_PACKAGE = "fastecdsa"
SRC_URI[sha256sum] = "f35255a6d3e41109166b5d4b08866d5acbb99f2e1e64d3a7e74c774664cda842"

inherit pypi setuptools3_legacy python3native

do_install:append() {
	# Remove invalid UNKNOWN-0.0.0-py3.10.egg-info directory
	rm -r ${D}${PYTHON_SITEPACKAGES_DIR}/UNKNOWN-0.0.0-py3.10.egg-info

	# Install valid egg-info information
	cp -r ${S}/fastecdsa.egg-info ${D}${PYTHON_SITEPACKAGES_DIR}/fastecdsa-${PV}-py${PYTHON_BASEVERSION}.egg-info

	# Add all missing files
	cp -r ${S}/fastecdsa ${D}${PYTHON_SITEPACKAGES_DIR}/
}

PACKAGES =+ "${PN}-tests"
FILES:${PN}-tests = "${PYTHON_SITEPACKAGES_DIR}/fastecdsa/tests/"

RDEPENDS:${PN}-tests = "${PN}"

BBCLASSEXTEND = "native"
