# MImageViewer
android网络图片查看器。
<br/>

## 支持
Android 4.0+
<br/>

## 混淆
#### 无

## Gradle 

在项目的gradle中添加
```
	allprojects {
		repositories {
			maven{
				url 'https://jitpack.io'
        }
		}
	}
```

在app的gradle中添加
 ```
compile 'com.github.MrxMo:MImageViewer:v1.0'
	
 ```
 <br/>

## 使用
* 设置图片源

```		
 ArrayList<String> imageList = new ArrayList<>();
        imageList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1498388783844&di=c847f652e64c39744657ef7ddc17eafa&imgtype=0&src=http%3A%2F%2Fimg.jj20.com%2Fup%2Fallimg%2F611%2F012513124K9%2F130125124K9-1-lp.jpg");
        imageList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1498388783843&di=c7de375c6603b913d07b484cd2dd9056&imgtype=0&src=http%3A%2F%2Fimg01.taopic.com%2F160528%2F240390-16052Q2430091.jpg");
        imageList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1498388820188&di=a411dadee1a0d24cc09f851412a527bf&imgtype=0&src=http%3A%2F%2Fi140.photobucket.com%2Falbums%2Fr3%2Fselexphoto%2F9-9.jpg");
        imageList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1498388783844&di=c847f652e64c39744657ef7ddc17eafa&imgtype=0&src=http%3A%2F%2Fimg.jj20.com%2Fup%2Fallimg%2F611%2F012513124K9%2F130125124K9-1-lp.jpg");
        imageList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1498388783843&di=c7de375c6603b913d07b484cd2dd9056&imgtype=0&src=http%3A%2F%2Fimg01.taopic.com%2F160528%2F240390-16052Q2430091.jpg");
        imageList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1498388820188&di=a411dadee1a0d24cc09f851412a527bf&imgtype=0&src=http%3A%2F%2Fi140.photobucket.com%2Falbums%2Fr3%2Fselexphoto%2F9-9.jpg");

```


* 打开图片浏览器

```		
  Intent intent = new Intent(this, MImageViewerActivity.class);
        intent.putStringArrayListExtra(MImageViewerActivity.PARAM_LIST_IMAGE_DATA, imageList);
        intent.putExtra(MImageViewerActivity.PARAM_INT_IMAGE_POSITION, 0);
        startActivity(intent);
```
<br/>




 