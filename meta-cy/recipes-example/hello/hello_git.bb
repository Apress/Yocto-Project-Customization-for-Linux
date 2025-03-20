SUMMARY = "Yet another hello world program"
DESCRIPTION = "A simple example about how to write a recipe for a user space C program."
MAINTAINER = "Rodolfo Giometti <giometti@enneenne.com>"
SECTION = "examples"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git:///home/giometti/yocto/examples/hello;branch=master"

PV = "1.0+git${SRCPV}"
SRCREV = "b3b4da551b6b25b56cc1fdad3f83ebfd88bcaeee"

S = "${WORKDIR}/git"

do_configure () {
	:
}

do_compile () {
	oe_runmake
}

do_install () {
	oe_runmake install 'DESTDIR=${D}'
}
