//通用的复制能力函数
function common_copy(text)
{
    console.log(text);
    var textArea = document.createElement("textarea");
    textArea.style.position = 'fixed';
    textArea.style.top = '0';
    textArea.style.left = '0';
    textArea.style.width = '2em';
    textArea.style.height = '2em';
    textArea.style.padding = '0';
    textArea.style.border = 'none';
    textArea.style.outline = 'none';
    textArea.style.boxShadow = 'none';
    textArea.style.background = 'transparent';
    textArea.value = text;
    document.body.appendChild(textArea);
    textArea.select();
    try {
        var successful = document.execCommand('copy');
        var msg = successful ? '复制成功' : '复制失败';
        layer.msg('已入剪切板~');
        console.log(msg);
    } catch (err) {
        console.log('复制失败');
    }
    document.body.removeChild(textArea);
}
//打开资料弹出框
function openProfilePopup(url, id, title) {
    // 打开弹窗
    layer.open({
        type: 2,
        title: title,
        area: ['650px', '500px'], // 设置弹窗大小
        content: url
    });
}
//请求接口并渲染select
function getSelect(apiUrl, selectElementId,cid, successCallback, failureCallback) {
    $.ajax({
        url: apiUrl, // 使用传入的接口URL
        type: 'GET',
        success: function(res) {
            if (res.status === 200) {
                let categories = res.data;
                // 填充选项
                categories.forEach(function(category) {
                    if (cid == category.id){
                        $('#' + selectElementId).append('<option value="' + category.id + '" selected>' + category.name + '</option>');
                    }else{
                        $('#' + selectElementId).append('<option value="' + category.id + '">' + category.name + '</option>');
                    }
                });
                // 调用成功回调
                successCallback && successCallback();
            } else {
                layer.popup.failure('加载失败，请重试');
            }
        },
        error: function() {
            // 调用失败回调
            failureCallback && failureCallback();
        }
    });
}
//editor用的复制粘贴上传图片函数
function initPasteDragImg(Editor){
    var doc = document.getElementById(Editor.id)
    doc.addEventListener('paste', function (event) {
        console.log("粘贴")
        var items = (event.clipboardData || window.clipboardData).items;
        var file = null;
        console.log("粘贴内容：", items);
        if (items && items.length) {
            // 搜索剪切板items
            for (var i = 0; i < items.length; i++) {
                if (items[i].type.indexOf('image') !== -1) {
                    file = items[i].getAsFile();
                    break;
                }
            }
        } else {
            console.log("当前浏览器不支持");
            return;
        }
        if (!file) {
            console.log("粘贴内容非图片");
            return;
        }
        uploadImg(file,Editor);
    });

    var dashboard = document.getElementById(Editor.id)
    dashboard.addEventListener("dragover", function (e) {
        console.log("拖动")
        e.preventDefault()
        e.stopPropagation()
    })
    dashboard.addEventListener("dragenter", function (e) {
        console.log("拖动")
        e.preventDefault()
        e.stopPropagation()
    })
    dashboard.addEventListener("drop", function (e) {
        console.log("拖动")
        e.preventDefault()
        e.stopPropagation()
        var files = this.files || e.dataTransfer.files;
        uploadImg(files[0],Editor);
    })
}
//上传图片
function uploadImg(file,Editor){
    var formData = new FormData();
    var fileName=new Date().getTime()+"."+file.name.split(".").pop();
    formData.append('editormd-image-file', file, fileName);
    $.ajax({
        url: Editor.settings.imageUploadURL,
        type: 'post',
        data: formData,
        processData: false,
        contentType: false,
        dataType: 'json',
        success: function (msg) {
            var success=msg['success'];
            if(success==1){
                var url=msg["url"];
                if(/\.(png|jpg|jpeg|gif|bmp|ico)$/.test(url)){
                    Editor.insertValue("![图片alt]("+msg["url"]+")");
                }else{
                    Editor.insertValue("[下载附件]("+msg["url"]+")");
                }
            }else{
                console.log(msg);
            }
        }
    });
}
