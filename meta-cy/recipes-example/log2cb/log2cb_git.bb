SUMMARY = "Basic circular buffer file manager log messages"
DESCRIPTION = "A basic circular buffer file creator and manager to store logging messages for embedded systems. The goal is to limit the size of ever-growing log to a maximum amount, loosing in the process oldest entries if the amount is exceeded."
HOMEPAGE = "https://gitlab.com/giometti/log2cb"
MAINTAINER = "Rodolfo Giometti <giometti@enneenne.com>"
SECTION = "utils"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=eb723b61539feef013de476e68b5c50a"

SRC_URI = "git://gitlab.com/giometti/log2cb.git;protocol=https;branch=main \
           file://0001-Makefile-force-dynamic-linked-files.patch \
           file://0002-Makefile-add-soname-support-for-dynamic-libraries.patch \
           file://0003-Makefile-fix-wrong-CC-and-AR-assignment.patch \
           "

PACKAGES += "lib${PN} ${PN}-tools ${PN}-tests"

# Modify these as desired
LOG2CB_VERSION = "1.5.0"
PV = "${LOG2CB_VERSION}+git${SRCPV}"
SRCREV = "v${LOG2CB_VERSION}"

S = "${WORKDIR}/git"

do_configure () {
	:
}

do_compile () {
	oe_runmake
}

do_install () {
	# Install library files
        install -m 0755 -d ${D}${libdir}
        oe_soinstall ${S}/liblog2cb.so.${LOG2CB_VERSION} ${D}${libdir}
        install -d ${D}${includedir}
        install -m 0755 ${S}/log2cb.h ${D}${includedir}

	# Install programs files
	install -d ${D}${bindir}
	install readcb writecb ${D}${bindir}
	install tools/cbheader tools/external_app ${D}${bindir}
}

FILES:${PN} = " \
    ${bindir}/readcb \
    ${bindir}/writecb \
"

FILES:lib${PN} = " \
    ${libdir}/liblog2cb.so* \
    ${includedir}/log2cb.h \
"
SUMMARY:lib${PN} = "Libraries for basic circular buffer file manager log messages"
SECTION:lib${PN} = "libs"

FILES:${PN}-tools = " \
    ${bindir}/cbheader \
"
SUMMARY:${PN}-tools = "Tools for basic circular buffer file manager log messages"
RDEPENDS:${PN}-tools = "${PN}"

FILES:${PN}-tests = " \
    ${bindir}/external_app \
"
SUMMARY:${PN}-tools = "Tests for basic circular buffer file manager log messages"
