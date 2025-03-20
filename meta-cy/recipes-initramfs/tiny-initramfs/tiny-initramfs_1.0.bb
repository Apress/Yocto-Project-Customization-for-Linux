SUMMARY = "CY tiny initramfs framework"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

PR = "r0"
S = "${WORKDIR}"

SRC_URI = " \
	file://fstab \
	file://init \
"

do_install() {
        install -d ${D}/tmp
        install -d ${D}/mnt
        install -d ${D}/dev
        mknod -m 622 ${D}/dev/console c 5 1

        install -d ${D}/proc
        install -d ${D}/sys

	install -d ${D}/etc
	install ${WORKDIR}/fstab ${D}/etc/fstab

	install -m 0755 ${WORKDIR}/init ${D}/init
}

FILES:${PN} = " \
	/dev /dev/console \
	/proc /sys /tmp /mnt \
	/etc /etc/fstab \
	/init \
"
