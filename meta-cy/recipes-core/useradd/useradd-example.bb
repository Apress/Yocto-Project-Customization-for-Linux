SUMMARY = "Example recipe for using inherit useradd"
DESCRIPTION = "This recipe serves as an example for using features from useradd.bbclass"
SECTION = "examples"
PR = "r1"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = "file://file1 \
           file://file2 \
           file://file3 \
           file://file4"

S = "${WORKDIR}"

PACKAGES =+ "${PN}-user3"

EXCLUDE_FROM_WORLD = "1"

inherit useradd

# You must set USERADD_PACKAGES when you inherit useradd. This
# lists which output packages will include the user/group
# creation code.
USERADD_PACKAGES = "${PN} ${PN}-user3"

# You must also set USERADD_PARAM and/or GROUPADD_PARAM when
# you inherit useradd.

# USERADD_PARAM specifies command line options to pass to the
# useradd command. Multiple users can be created by separating
# the commands with a semicolon. Here we'll create two users,
# user1 and user2:
USERADD_PARAM:${PN} = "-u 200 -d /home/user1 -r -s /bin/bash user1; -u 201 -d /home/user2 -r -s /bin/bash user2"

# user3 will be managed in the useradd-example-user3 pacakge:
# As an example, we use the -p option to set a password for user3 obtained by
# using the command:
#     mkpasswd -m sha-512 'cY!pass1'
#     $6$E80GB11MDb1xon3p$Hwhz.yRgjcW33qIaOVksyckbwX7UxLqUXsfscAuGbfkM6IYjlnnPoNHUdpQJYkEDNwLVjpm3xt1GKtWFmTnNv/
USERADD_PARAM:${PN}-user3 = "-u 202 -d /home/user3 -r -s /bin/bash -p '\$6\$E80GB11MDb1xon3p\$Hwhz.yRgjcW33qIaOVksyckbwX7UxLqUXsfscAuGbfkM6IYjlnnPoNHUdpQJYkEDNwLVjpm3xt1GKtWFmTnNv/' user3"

# GROUPADD_PARAM works the same way, which you set to the options
# you'd normally pass to the groupadd command. This will create
# groups group1 and group2:
GROUPADD_PARAM:${PN} = "-g 880 group1; -g 890 group2"

# Likewise, we'll manage group3 in the useradd-example-user3 package:
GROUPADD_PARAM:${PN}-user3 = "-g 900 group3"

do_install () {
	install -d -m 755 ${D}/home/user1
	install -d -m 755 ${D}/home/user2
	install -d -m 755 ${D}/home/user3

	install -p -m 644 file1 ${D}/home/user1/
	install -p -m 644 file2 ${D}/home/user1/

	install -p -m 644 file2 ${D}/home/user2/
	install -p -m 644 file3 ${D}/home/user2/

	install -p -m 644 file3 ${D}/home/user3/
	install -p -m 644 file4 ${D}/home/user3/

	# The new users and groups are created before the do_install
	# step, so you are now free to make use of them:
	chown -R user1 ${D}/home/user1
	chown -R user2 ${D}/home/user2
	chown -R user3 ${D}/home/user3

	chgrp -R group1 ${D}/home/user1
	chgrp -R group2 ${D}/home/user2
	chgrp -R group3 ${D}/home/user3
}

FILES:${PN} = "/home/user1/* /home/user2/*"
FILES:${PN}-user3 = "/home/user3/*"

# Prevents do_package failures with:
# debugsources.list: No such file or directory:
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
