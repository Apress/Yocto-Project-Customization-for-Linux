SUMMARY = "Yet another hello world library"
DESCRIPTION = "A simple example about how to write a recipe for a user space C library."
MAINTAINER = "Rodolfo Giometti <giometti@enneenne.com>"
SECTION = "libs"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git:///home/giometti/yocto/examples/hellolib;branch=master"

PV = "1.0+git${SRCPV}"
SRCREV = "ce5c28efa3446c44e6b6b4ba1593639c493fe410"

S = "${WORKDIR}/git"

do_configure () {
	:
}

do_compile () {
	oe_runmake
}

do_install () {
	install -m 0755 -d ${D}${libdir}
	oe_soinstall ${S}/libhello.so.1.0.0 ${D}${libdir}
	install -d ${D}${includedir}
	install -m 0755 ${S}/*.h ${D}${includedir}
}
