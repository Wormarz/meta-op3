# Standalone wpa_supplicant for wlan0 (NetworkManager is not used).
# Ships a default per-interface config and enables wpa_supplicant@wlan0,
# so the device can connect via wpa_cli out of the box.
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