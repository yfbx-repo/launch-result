# ResultHelper
[![](https://img.shields.io/badge/release-1.0.0-blue.svg)](https://github.com/yfbx-repo/launch-result/releases)

extensions to start activity for result and request permissions,based on:
```
'androidx.activity:activity-ktx:1.2.0-alpha08'
'androidx.fragment:fragment-ktx:1.3.0-alpha08'
```

### dependencies

```
dependencies {
    implementation 'com.github.yfbx-repo:launch-result:1.0.0-alpha'
}
```    

### sample

- start activity for result
```
 launchFor<TestActivity>("key" to "MainActivity") {
    toast("resultCode = ${it.resultCode},data = ${it.data.toString()}")
 }

```

- request permission

```
 permissionFor(Manifest.permission.WRITE_EXTERNAL_STORAGE) {
     toast("permission ${if (it) "granted" else "denied"}")
 }
```
