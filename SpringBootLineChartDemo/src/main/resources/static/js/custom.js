jQuery(document).ready(function () {

    jQuery("#btn-check").click(function () {
        alert("jQuery work properly !");
    });

    // line chart
    $.ajax({
        url : "http://localhost:8081/line_chart/linechartapi",
        type : "GET",
        success : function (data) {
            console.log(data);
            var userid = [];
            var facebook_f = [];
            var twitter_f = [];
            var googleplus_f = [];

            for (var i in data)
            {
                userid.push("UserId" + data[i].id);
                facebook_f.push(data[i].facebook);
                twitter_f.push(data[i].twitter);
                googleplus_f.push(data[i].google_plus);
            }

            var chartdata = {
                labels: userid,
                datasets: [
                    {
                    label: "facebook",
                    fill: false,
                    lineTension: 0.1,
                    backgroundColor: 'rgba(59, 89, 152, 0.75)',
                    borderColor: 'rgba(59, 89, 152, 1)',
                    borderWidth: 1,
                    pointHoverBackgroundColor: 'rgba(59, 89, 152, 0.75)',
                    pointHoverBorderColor: 'rgba(59, 89, 152, 0.75)',
                    data: facebook_f
                    },
                    {
                    label: "twitter",
                    fill: false,
                    lineTension: 0.1,
                    backgroundColor: 'rgba(29, 202, 255, 0.75)',
                    borderColor: 'rgba(29, 202, 255, 1)',
                    borderWidth: 1,
                    pointHoverBackgroundColor: 'rgba(29, 202, 255, 1)',
                    pointHoverBorderColor: 'rgba(29, 202, 255, 1)',
                    data: twitter_f
                    },
                    {
                    label: "google_plus",
                    fill: false,
                    lineTension: 0.1,
                    backgroundColor: 'rgba(211, 72, 54, 0.75)',
                    borderColor: 'rgba(211, 72, 54, 1)',
                    borderWidth: 1,
                    pointHoverBackgroundColor: 'rgba(211, 72, 54, 1)',
                    pointHoverBorderColor: 'rgba(211, 72, 54, 1)',
                    data: googleplus_f
                }
                ]
            };

            var ctx = $("#mycanvas");
            var LineGraph = new Chart(ctx, {
                type : 'bar',
                data: chartdata
            });

            var ctx1 = $("#mycanvas1");
            var LineGraph = new Chart(ctx1, {
                type : 'line',
                data: chartdata
            });
        },
        error : function (data) {

        }
    });
})