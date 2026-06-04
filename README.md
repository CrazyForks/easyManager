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

轻风是一款轻量化、核心化、简洁易用的安卓工具应用，适合在中国OEM厂商定制系统使用，提供ADB、ROOT、设备管理员三种模式运行，稳定可靠，上手简单。
正如它的名字一样，轻风轻拂而来，悄然离去，不破坏、不越权，只专注做好本职工作，克制纯粹。

轻风集成应用批量权限管理、批量冻结/禁用、批量卸载、静默安装卸载、分身管理、后台清理、网络管控、备份恢复、文件共享等功能，可修复类原生系统信号×图标、自定义NTP服务器同步国内时间、调节系统刷新率，并支持通过ADB或Root执行系统命令。
应用操作简单，内置丰富一键功能，查看帮助文档后选择对应规则，点击即可完成任务。
其中备份恢复、解除分身限制、网络管控、应用组件管理需Root权限；设备管理员权限仅支持应用冻结/解冻、图标隐藏/显示。

轻风的工作原理参考了 Shizuku、AppOps、Hail、Dhizuku、InstallerX 等多款优秀开源项目。与同类工具一样，轻风需要引导用户执行一条命令，在后台启动独立的 Shell 或 Root Shell 进程，才能正常运行。
与它们不同的是，轻风基于 Socket 建立 TCP 通信，通过发送操作指令与参数完成相应功能，所有执行逻辑均运行在独立 Shell 中，用户可随时停止服务。

从V1.2.8b版本开始，该项目分成两个版本，分开维护和更新，分别是 [轻风免root版本](https://github.com/MrsEWE44/easyManager/tree/md5) 和 [轻风完整版](https://github.com/MrsEWE44/easyManager/tree/master)


- V1.3.2a

1.修复在获取分身应用时闪退的问题。

2.修改版本号为1.3.2a.


### 软件截图:

<table align="center" border="0" cellpadding="10">

  <tr>
    <td align="center">
      <img src="images/3.png" width="250"><br>
      <b>图片1</b>
    </td>
    <td align="center">
      <img src="images/4.png" width="250"><br>
      <b>图片2</b>
    </td>
    <td align="center">
      <img src="images/1.png" width="250"><br>
      <b>图片3</b>
    </td>
  </tr>

  <tr>
    <td align="center">
      <img src="images/2.png" width="250"><br>
      <b>图片4</b>
    </td>
    <td align="center">
      <img src="images/5.png" width="250"><br>
      <b>图片5</b>
    </td>
    <td align="center">
      <img src="images/6.png" width="250"><br>
      <b>图片6</b>
    </td>
  </tr>
</table>

### 捐赠&支持作者

<table align="center" border="0" cellpadding="15">
  <tr>
    <td align="center">
      <img src="app/src/main/assets/wechatqr.jpg" width="200"><br>
      <b>微信</b>
    </td>
    <td align="center">
      <img src="app/src/main/assets/aliqr.jpg" width="200"><br>
      <b>支付宝</b>
    </td>
  </tr>
</table>


