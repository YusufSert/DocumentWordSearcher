google.charts.load("current", { packages: ["corechart"] });

let array = [];

function drawChart() {
  var data = google.visualization.arrayToDataTable([
    ["Element", "time", { role: "style" }],
    ["Binary", array[0], "#b87333"],
    ["Linear", array[1], "silver"],
    ["Search", array[2], "gold"],
  ]);

  var view = new google.visualization.DataView(data);
  view.setColumns([
    0,
    1,
    { calc: "stringify", sourceColumn: 1, type: "string", role: "annotation" },
    2,
  ]);

  var options = {
    title: "Search Time",
    width: 500,
    height: 400,
    bar: { groupWidth: "75%" },
    legend: { position: "none" },
  };
  var chart = new google.visualization.ColumnChart(
    document.getElementById("chart_div")
  );
  chart.draw(view, options);
}

$("#btn").on("click", function (e) {
  e.preventDefault();
  let searchTech = $("input[name=search-tech]:checked").val();

  //ajax call to api
  $.get(
    "http://localhost:8080/data/" + searchTech,
    "word=" + $("#search-input").val(),
    function (data) {
      $(".tBody").empty();
      let msg = "";
      $.each(data.list, function (indexInArray, valueOfElement) {
        array.push(data.time);
        msg += `
        <tr>
        <td>${indexInArray + 1}</td>
        <td>${valueOfElement}</td>
        <td>
          <a class="btn-read" href="http://localhost:8080/data/read?fileName=${valueOfElement}">show</a>
        </td>
      </tr>`;
      });
      $(".tBody").append(msg);
    }
  );
});

$(".btn-cart").on("click", (e) => {
  e.preventDefault();
  google.charts.setOnLoadCallback(drawChart);
});
