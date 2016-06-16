# ContentObservables

[![JitPack](https://img.shields.io/github/tag/yongjhih/content-observables.svg?label=JitPack)](https://jitpack.io/#yongjhih/content-observables)
[![javadoc](https://img.shields.io/github/tag/yongjhih/content-observables.svg?label=javadoc)](https://jitpack.io/com/github/yongjhih/content-observables/-SNAPSHOT/javadoc/)
[![Build Status](https://travis-ci.org/yongjhih/content-observables.svg)](https://travis-ci.org/yongjhih/content-observables)
[![Coverage Status](https://coveralls.io/repos/github/yongjhih/content-observables/badge.svg)](https://coveralls.io/github/yongjhih/content-observables)

## Usage

```java
ContentObservables.from(context).with(handler).on(uri).subscribe(changed -> changed ? button.on() : button.off());
```

```java
ContentObservables.from(context).with(handler).on(uri).subscribe((changed, uri) -> changed ? button.on() : button.off());
```

```java
ContentObservables.from(context).on(uri).subscribe(new LambdaContentObserver(handler).onChange((changed, uri) -> changed ? button.on() : button.off());
```

```java
ContentObservables.from(context).on(uri).subscribe(new LambdaContentObserver(handler).onChange(changed -> changed ? button.on() : button.off());
```

## Installation

via jitpack:

```gradle
repositories {
    jcenter()
    maven { url "https://jitpack.io" }
}

dependencies {
    compile 'com.github.yongjhih:content-observables:-SNAPSHOT'
    //compile 'com.github.yongjhih:content-observables:0.0.1'
}
```

### Test

```sh
./gradlew :content-observables:test
```

### Coverage

```sh
./gradlew :content-observables:jacocoTestReport
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
