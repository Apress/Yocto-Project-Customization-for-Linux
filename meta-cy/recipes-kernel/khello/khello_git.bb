SUMMARY = "Yet another hello world kernel module"
DESCRIPTION = "A simple example about how to write a recipe for a kernel space C module."
MAINTAINER = "Rodolfo Giometti <giometti@enneenne.com>"
SECTION = "kernel"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "git:///home/giometti/yocto/examples/khello;branch=master"

PV = "1.0+git${SRCPV}"
SRCREV = "57fe9a7f816aa34ba88a759812d188dd82dc0175"

S = "${WORKDIR}/git"

inherit module
