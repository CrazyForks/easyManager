<h1 align="center">轻风 | Light Breeze</h1>

<p align="center">
  🇺🇸 <a href="./README_EN.md">English</a> | 🇨🇳 <a href="./README.md">简体中文</a>
</p>

<p align="center">
 <a href="https://github.com/MrsEWE44/easyManager/releases"><img alt="GitHub Release" src="https://img.shields.io/github/v/release/MrsEWE44/easyManager"></a>
 <a><img alt="GitHub Repo stars" src="https://img.shields.io/github/stars/MrsEWE44/easyManager?style=flat"></a>
 <a><img alt="GitHub forks" src="https://img.shields.io/github/forks/MrsEWE44/easyManager?style=flat"></a>
 <a><img alt="GitHub Downloads (all assets, all releases)" src="https://img.shields.io/github/downloads/MrsEWE44/easyManager/total"></a>
 <a><img alt="GitHub watchers" src="https://img.shields.io/github/watchers/MrsEWE44/easyManager?style=flat"></a>

</p>

Light Breeze is a lightweight, focused, and easy-to-use Android utility. It works well on custom systems from Chinese OEMs and supports three operating modes: ADB, ROOT, and Device Owner. It is stable, reliable, and simple to use.True to its name, Light Breeze comes gently and leaves quietly. It does not harm the system or abuse permissions, focusing only on its core tasks with restraint and purity.

Light Breeze provides app batch permission management, batch freeze/disable, batch uninstall, app clone management, background process cleanup, batch silent install/uninstall, single app service/activity/broadcast/permission management, batch network control, batch backup & restore, file sharing, and more. It also fixes the "×" signal icon issue on AOSP-like systems, supports modifying NTP servers for China time synchronization, adjusting system refresh rate, and running system commands via ADB or Root.
It comes with many one-click functions. Just read the documentation, select the corresponding rule, and tap the button to get things done.
Backup & restore, unlimit app cloning, network control, and app service/activity/broadcast management require Root access. Device Owner mode only supports app freeze/unfreeze and icon hide/show.

Light Breeze’s working principle references excellent open-source projects including Shizuku, AppOps, Hail, Dhizuku, and InstallerX. Similar to these tools, Light Breeze requires users to run a command to start an independent background shell or root shell process for normal operation.
Unlike them, Light Breeze uses Socket-based TCP communication to execute operations by sending instructions and parameters. All actions run within an isolated shell, and you can stop the service at any time.

What can it do? How does it make things easier for you?

1.It allows you to uninstall certain pre-installed system apps—even those that cannot be removed via standard adb shell commands—without requiring root access; it also supports reinstalling them later. It is compatible with systems from brands such as Vivo, iQOO, Oppo, OnePlus, Realme, Honor, and Samsung.

2.On Android versions prior to Android 10, it allows you to manage sensor permissions for individual apps and disable them without root access, helping to mitigate the annoyance of "shake-to-trigger" ads.

3.With root access, it can turn your phone into a bootable drive, enabling you to install operating systems—such as Windows or Linux—on a computer.

4.With root access, it bypasses system limits on the number of app clones, effectively allowing for unlimited cloning; each clone operates independently and consumes minimal system resources.

5.It allows you to share the contents of a folder over a local network via Wi-Fi, making it easy for others to access and download the files.

Starting with version V1.2.8b, this project is divided into two versions, which are maintained and updated separately: [Light Breeze No-Root Version](https://github.com/MrsEWE44/easyManager/tree/md5) and [Light Breeze Full Version](https://github.com/MrsEWE44/easyManager/tree/master).


- V1.3.3c

1.Improved sensor access controls for Android versions prior to Android 11.

2.Adjusted the destination screen for software update checks.

3.Updated the version number to 1.3.3c.


### Software screenshots:

<table align="center" border="0" cellpadding="10">

  <tr>
    <td align="center">
      <img src="images/3.png" width="250"><br>
      <b>Image1</b>
    </td>
    <td align="center">
      <img src="images/4.png" width="250"><br>
      <b>Image2</b>
    </td>
    <td align="center">
      <img src="images/1.png" width="250"><br>
      <b>Image3</b>
    </td>
  </tr>

  <tr>
    <td align="center">
      <img src="images/2.png" width="250"><br>
      <b>Image4</b>
    </td>
    <td align="center">
      <img src="images/5.png" width="250"><br>
      <b>Image5</b>
    </td>
    <td align="center">
      <img src="images/6.png" width="250"><br>
      <b>Image6</b>
    </td>
  </tr>
</table>

### Donate & Support Authors

<table align="center" border="0" cellpadding="15">
  <tr>
    <td align="center">
      <img src="app/src/main/assets/wechatqr.jpg" width="200"><br>
      <b>WechatPay</b>
    </td>
    <td align="center">
      <img src="app/src/main/assets/aliqr.jpg" width="200"><br>
      <b>AliPay</b>
    </td>
  </tr>
</table>


