var $parentNode = window.parent.document;

function $childNode(name) {
    return window.frames[name]
}

// tooltips
$('.tooltip-demo').tooltip({
    selector: "[data-toggle=tooltip]",
    container: "body"
});

// 使用animation.css修改Bootstrap Modal
$('.modal').appendTo("body");

$("[data-toggle=popover]").popover();

//折叠ibox
$('body').on("click", ".collapse-link", function () {
    var ibox = $(this).closest('div.ibox');
    var button = $(this).find('i');
    var content = ibox.find('div.ibox-content');
    content.slideToggle(200);
    button.toggleClass('fa-chevron-up').toggleClass('fa-chevron-down');
    ibox.toggleClass('').toggleClass('border-bottom');
    setTimeout(function () {
        ibox.resize();
        ibox.find('[id^=map-]').resize();
    }, 50);
});

//关闭ibox
$('body').on("click", '.close-link', function () {
    var content = $(this).closest('div.ibox');
    content.remove();
});
//判断当前页面是否在iframe中
// if (top == this) {
//     var gohome = '<div class="gohome"><a class="animated bounceInUp" href="index.html?v=4.0" title="返回首页"><i class="fa fa-home"></i></a></div>';
//     $('body').append(gohome);
// }

//animation.css
function animationHover(element, animation) {
    element = $(element);
    element.hover(
        function () {
            element.addClass('animated ' + animation);
        },
        function () {
            //动画完成之前移除class
            window.setTimeout(function () {
                element.removeClass('animated ' + animation);
            }, 2000);
        });
}

//拖动面板
function WinMove() {
    var element = "[class*=col]";
    var handle = ".ibox-title";
    var connect = "[class*=col]";
    $(element).sortable({
        handle: handle,
        connectWith: connect,
        tolerance: 'pointer',
        forcePlaceholderSize: true,
        opacity: 0.8,
    })
        .disableSelection();
};

//auto resizee
function autoResizeIframe(id) {
    try {
        document.getElementById(id).height = "100%";
        var newheight = document.getElementById(id).contentWindow.document.body.scrollHeight;
        //var newwidth = document.getElementById(id).contentWindow.document.body.scrollWidth;
        //document.getElementById(id).width = (newwidth) + "px";
        document.getElementById(id).height = (newheight) + "px";
    } catch (ex) {
        if (window.console && console.log) console.log(ex);
    }
}

/**
 * 把JSON数据绑定到控件
 */
function bindJson2Form(json, filters) {
  for (var property in json) {
    if (filters) {
      if ((filters+"").indexOf(",") > 0) {
        var filterArray = filters.split(",");
        if (!filterArray.contains(property)) {
          continue;
        }
      } else if ($.type(filters) === "string") {
        var ancestor = $(filters);
        var elem = $(property);
        if (ancestor && elem && !Element.descendantOf(elem, ancestor)) {
          continue;
        }
      } else if ($.type(filters) === "array") {
        if (!filters.contains(property)) {
          continue;
        }
      }
    }

    var value = json[property];  
    var cntrlArray = document.getElementsByName(property);    
    var cntrlCnt = cntrlArray.length;
    if (!cntrlArray || cntrlCnt < 1) {
      if (document.getElementById(property)) {
        cntrlArray = [document.getElementById(property)];
        cntrlCnt = 1;
      }else {
        continue;
      }
    }

    if (cntrlCnt == 1) {
      var cntrl = cntrlArray[0];
      if (cntrl.tagName.toLowerCase() == "input" && cntrl.type.toLowerCase() == "checkbox") {
        if (cntrl.value == value) {
          cntrl.checked = true;
        } else {
          cntrl.checked = false;
        }
      } else if (cntrl.tagName.toLowerCase() == "td" || cntrl.tagName.toLowerCase() == "div" || cntrl.tagName.toLowerCase() == "span") {
        cntrl.innerHTML = value;
      } else if (cntrl.tagName.toLowerCase() == 'select') {
        for (var i = 0; i < cntrl.childNodes.length; i++) {
          if (cntrl.childNodes[i].value == value) {
            cntrl.childNodes[i].setAttribute("selected", "selected");
            break;
          }
        }
      } else {
        cntrl.value = value;
      }
    } else {
      for (var i = 0; i < cntrlCnt; i++) {
        var cntrl = cntrlArray[i];
        if (cntrl.value == value) {
          cntrl.checked = true;
        } else {
          cntrl.checked = false;
        }
      }
    }
  }  
}


