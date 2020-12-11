function logout() {
    $.get("/user/logout", function(result) {
        if (200 == result.status) {
            window.location = "/api/user/index";
        }
    });
}

/**
 * 打开或切换选项卡
 * @param code
 * @param text
 * @param url
 */
function newTab(code, text, url) {
    var element = layui.element;
    var exist = $("li[lay-id='" + code + "']").length;
    if (0 >= exist) {
        element.tabAdd('maintab', {
            title: text,
            content: '<iframe frameborder="0" width="100%" scrolling="auto" src="' + url + '"></iframe>',
            id: code
        })
    }
    $(".layui-tab-content").find('iframe').each(function() {
        $(this).height($(window).height() - 125);
    });
    element.tabChange('maintab', code);
}