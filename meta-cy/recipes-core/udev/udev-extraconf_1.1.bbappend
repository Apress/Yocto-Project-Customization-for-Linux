FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://mmcblk.exclude.list"

do_install:append() {
    install -m 0644 ${WORKDIR}/mmcblk.exclude.list \
                    ${D}${sysconfdir}/udev/mount.ignorelist.d/mmcblk.list
}
