$(function () {
    if ($.fn.select2) {
        $.fn.select2.defaults.set("theme", "bootstrap");
        $.fn.select2.defaults.set("minimumResultsForSearch", "Infinity");
        $.fn.select2.defaults.set("width", null);
        $.fn.select2.defaults.set("placeholder", "--");
        $.fn.select2.defaults.set("allowClear", false);
        $.fn.select2.defaults.set("closeOnSelect", true);
        $.fn.select2.defaults.set("selectOnClose", false);
    }
    if ($.fn.datepicker) {
        // $.fn.datepicker.defaults.language = "zh";
        $.fn.datepicker.defaults.orientation = "bottom auto";
        $.fn.datepicker.defaults.format = "yyyy-mm-dd";
        $.fn.datepicker.defaults.startDate = "d";
        $.fn.datepicker.defaults.maxViewMode = 2;
        $.fn.datepicker.defaults.autoclose = true;
        $.fn.datepicker.defaults.todayHighlight = true;
        $.fn.datepicker.defaults.daysOfWeekHighlighted = [0, 6];
    }
});
