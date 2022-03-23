# fragment  & recyclerView综合使用笔记

demo地址：https://github.com/HUSTerCH/FragmentTest

## fragment简介

​	fragment顾名思义碎片，是比activity体量更小的一个组件，一个activity可以有多个fragment，fragment也和布局文件进行绑定，继承自 fragment()类

## demo介绍

### 总

​	本demo也主要分为三个部分，数据类(model)，视图类(view)以及中继的viewModel 和 adapter；demo为手机和平板兼容模式，在手机模式下主界面只会显示一个recyclerView，在平板模式下则会在主界面左侧显示recyclerView，若点击任意一个item，则会在右侧的屏幕显示该item的详细信息

### view层

​	view层主要有MainActivity和DetailActivity两个activity，DetailPage和MainPage两个fragment，对应的布局文件有，两个activity_main(一个普通的用于手机，一个有限定符large的，用于适配平板)，main_page对应MainPage，news_detail对应DetailPage，news_detail_page对应DetailPage，news_item用于适配recyclerView的子项

当设备是平板时，使用MainActivity包含两个fragment，当设备是手机时，会在MainActivity和DetailActivity之间跳转

### 	model层

没啥好说的，最简单的一层

### 适配器层

#### ViewModel：

MainViewModel层代码：

```kotlin
package com.example.fragmenttest.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fragmenttest.model.Data
import java.lang.IllegalArgumentException

class MainViewModel(val data: Data) : ViewModel() {
    val newsData = data.getNews()
}

class MainViewModelFactory(): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(data = Data.getData()) as T
        }
        throw IllegalArgumentException("Unknown")
    }
}
```

同上次的recyclerView 的demo一样，最核心的部分是下面的MainViewModelFactory，这是固定写法，在fragment中，采用：

```kotlin
private val mainViewModel by activityViewModels<MainViewModel> {
        MainViewModelFactory()
    }
```

写法，为该fragment创建一个viewModel，注意是 **by activityViewModels** 而在activity中则是 **by viewModels** 

除此之外，livedata想要在fragment中被观察，观察的owner应写 **viewLifeCycleOwner**而不是像在activity中一样写**this** 

#### Adapter：

基本和recyclerView那个test一样，不做更多赘述

## 写该demo得到的经验：

1.gradle是个很重要的东西，一定要注意各种包的导入，其他项目的gradle最好不要直接拿来用，找找对应包的导入

2.在写布局文件的时候，因为AS的res里的文件夹内部不支持分区，所以在给xml文件命名的时候，最好加上前缀加以区分，在各种名字相近的xml文件中，内部的控件的id命名最好也要更有辨识度一些，不然会很混乱

最后：github desktop yyds！！！