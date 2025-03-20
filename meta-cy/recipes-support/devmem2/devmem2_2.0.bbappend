SRC_URI += "file://cy_devmem2;subdir=git"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_install:append:imx8mp-icore-cy() {
    install -d ${D}${bindir}
    install cy_devmem2 ${D}${bindir}
}
