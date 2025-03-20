LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

DEPENDS = "python3-fastecdsa-native"

SRC_URI = "git:///home/giometti/yocto/examples/ecdemo/;branch=master"

PV = "1.0+git${SRCPV}"
SRCREV = "64af940badaa46fd4b5eb3b176aeddfc980db611"

S = "${WORKDIR}/git"

do_configure () {
	:
}

do_compile () {
	oe_runmake
}

do_install () {
	install -d ${D}/${bindir}
	install print_key ${D}/${bindir}/
}
