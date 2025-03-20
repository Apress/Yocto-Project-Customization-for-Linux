SUMMARY = "Simple example of systemd service"
DESCRIPTION = "A simple example of the skeleton daemon installed as a systemd service"
MAINTAINER = "Rodolfo Giometti <giometti@enneenne.com>"
SECTION = "base"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${WORKDIR}/COPYRIGHT;md5=349c872e0066155e1818b786938876a4"

inherit systemd

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = "skeleton.service"

SRC_URI = " \
        file://skeleton.service \
	file://skeleton_test.c \
	file://COPYRIGHT \
"

do_compile () {
	${CC} ${CFLAGS} ${LDFLAGS} ${WORKDIR}/skeleton_test.c -o ${WORKDIR}/skeleton-test

}

do_install() {
        install -d ${D}/${systemd_unitdir}/system
	cat ${WORKDIR}/skeleton.service | \
	  sed -e 's,/etc,${sysconfdir},g' \
	      -e 's,/usr/sbin,${sbindir},g' \
	      -e 's,/var,${localstatedir},g' \
	      -e 's,/usr/bin,${bindir},g' \
	      -e 's,/usr,${prefix},g' > \
                ${D}/${systemd_unitdir}/system/skeleton.service

        install -d ${D}/${sbindir}
        install -m 0700 ${WORKDIR}/skeleton-test ${D}/${sbindir}/skeleton-test
}

FILES:${PN} += "${systemd_unitdir}/system/skeleton.service"
