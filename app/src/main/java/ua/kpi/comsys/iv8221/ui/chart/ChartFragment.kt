package ua.kpi.comsys.iv8221.ui.chart

import  ua.kpi.comsys.iv8221.R
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.intrusoft.scatter.ChartData
import com.intrusoft.scatter.PieChart
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries
import kotlin.math.E
import kotlin.math.cos
import kotlin.math.pow


class ChartFragment : Fragment() {

    private lateinit var chartViewModel: ChartViewModel
    private lateinit var graph: GraphView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        chartViewModel =
            ViewModelProvider(this).get(ChartViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_chart, container, false)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        init()
        drawGraph()
        drawPieChart()
    }


    private fun init() {
        graph = view!!.findViewById(R.id.graph)
    }

    private fun drawPieChart() {
        val pieChart = view!!.findViewById(R.id.pie_chart) as PieChart
        val data = ArrayList<ChartData>()
        data.add(ChartData("Blue 45%", 45f, Color.WHITE, Color.parseColor("#00bfff")))
        data.add(ChartData("Purple 5%", 5f, Color.WHITE, Color.parseColor("#800080")))
        data.add(ChartData("Yellow 25%", 25f, Color.WHITE, Color.YELLOW))
        data.add(ChartData("Gray 25%", 25f, Color.WHITE, Color.GRAY))
        pieChart.setChartData(data)
    }

    private fun drawGraph() {
        val start = -3.14
        val end = 3.14
        val maxPoints = 100
        val arrOfX: DoubleArray = funcX(start, end, maxPoints)
        val arrOfY = DoubleArray(maxPoints) { expFun(arrOfX[it]) }
        val series = LineGraphSeries<DataPoint>()

        for (i in 0 until maxPoints)
            series.appendData(DataPoint(arrOfX[i], arrOfY[i]), false, arrOfX.size)

        graph.viewport.isXAxisBoundsManual = true
        graph.viewport.setMaxX(end)
        graph.viewport.setMinX(start)
        graph.viewport.isYAxisBoundsManual = true
        graph.viewport.setMaxY(3.0)
        graph.viewport.setMinY(-3.0)
        graph.addSeries(series)
    }

    private fun expFun(x: Double) = cos(x)

    private fun funcX(start: Double, stop: Double, num: Int) =
        DoubleArray(num) { start + it * ((stop - start) / (num - 1)) }
}
