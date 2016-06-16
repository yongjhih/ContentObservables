# Rx Content

[![JitPack](https://img.shields.io/github/tag/yongjhih/rx-content.svg?label=JitPack)](https://jitpack.io/#yongjhih/rx-content)
[![javadoc](https://img.shields.io/github/tag/yongjhih/rx-content.svg?label=javadoc)](https://jitpack.io/com/github/yongjhih/rx-content/-SNAPSHOT/javadoc/)
[![Build Status](https://travis-ci.org/yongjhih/rx-content.svg)](https://travis-ci.org/yongjhih/rx-content)
[![Coverage Status](https://coveralls.io/repos/github/yongjhih/rx-content/badge.svg)](https://coveralls.io/github/yongjhih/rx-content)

## Usage

```java
ContentResolvers.from(context).with(handler).on(uri).subscribe(changed -> changed ? button.on() : button.off());
```

```java
ContentResolvers.from(context).with(handler).on(uri).subscribe((changed, uri) -> changed ? button.on() : button.off());
```

```java
ContentResolvers.from(context).on(uri).subscribe(new LambdaContentObserver(handler).onChange((changed, uri) -> changed ? button.on() : button.off());
```

```java
ContentResolvers.from(context).on(uri).subscribe(new LambdaContentObserver(handler).onChange(changed -> changed ? button.on() : button.off());
```

## Installation

via jitpack:

```gradle
repositories {
    jcenter()
    maven { url "https://jitpack.io" }
}

dependencies {
    compile 'com.github.yongjhih:rx-content:-SNAPSHOT'
    //compile 'com.github.yongjhih:rx-content:0.0.1'
}
```

### Test

```sh
./gradlew :rx-content:test
```

### Coverage

```sh
./gradlew :rx-content:jacocoTestReport
```

## License

```
Copyright 2016 Andrew Chen

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
