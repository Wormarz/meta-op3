# Standalone wpa_supplicant for wlan0 (NetworkManager is not used).
# Ships a per-interface config for both systemd and SysV init images.
# WiFi credentials are configured on the device, never embedded here.
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://wpa_supplicant-wlan0.conf"

do_install:append() {
    install -d ${D}${sysconfdir}/wpa_supplicant
    install -m 0600 ${UNPACKDIR}/wpa_supplicant-wlan0.conf ${D}${sysconfdir}/wpa_supplicant/wpa_supplicant-wlan0.conf
}

# Enable wpa_supplicant@wlan0.service (the plain wpa_supplicant.service
# daemon is also enabled by AUTO_ENABLE; it is a harmless D-Bus-only stub).
SYSTEMD_SERVICE:${PN} += "wpa_supplicant@wlan0.service"
SYSTEMD_AUTO_ENABLE:${PN} = "enable"

FILES:${PN} += "${sysconfdir}/wpa_supplicant/wpa_supplicant-wlan0.conf"
CONFFILES:${PN} += "${sysconfdir}/wpa_supplicant/wpa_supplicant-wlan0.conf"
# The base poky image uses SysV init: systemd enablement alone does not
# start WPA or DHCP there. Keep the board-tested standalone startup sequence.
inherit update-rc.d
INITSCRIPT_NAME = "wifi-autoconnect"
INITSCRIPT_PARAMS = "start 08 2 3 4 5 . stop 79 0 1 6 ."

SRC_URI += "file://wifi-autoconnect"
RDEPENDS:${PN}:append = "${@bb.utils.contains('DISTRO_FEATURES', 'sysvinit', ' wpa-supplicant-cli dhcpcd busybox', '', d)}"

do_install:append() {
    if ${@bb.utils.contains('DISTRO_FEATURES', 'sysvinit', 'true', 'false', d)}; then
        install -d ${D}${sysconfdir}/init.d
        install -m 0755 ${UNPACKDIR}/wifi-autoconnect ${D}${sysconfdir}/init.d/wifi-autoconnect
    fi
}
