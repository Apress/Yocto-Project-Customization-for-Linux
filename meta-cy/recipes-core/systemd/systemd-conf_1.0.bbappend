FILESEXTRAPATHS:prepend := "${THISDIR}/systemd-conf:"

SRC_URI += " \
    file://eth0.network \
"

FILES:${PN} += " \
    ${sysconfdir}/systemd/network/50-eth0.network \
"

do_install:append() {
    install -d ${D}${sysconfdir}/systemd/network
    install -m 0644 ${WORKDIR}/eth0.network ${D}${sysconfdir}/systemd/network/50-eth0.network
}
