package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * StatsChartItem represents a single chart data item for statistics visualization.
 *
 * This model encapsulates time-series data for charting and analytics, comparing
 * current period metrics against previous period metrics. It's designed to support
 * various chart types including line charts, bar charts, and trend visualizations
 * for business intelligence and reporting.
 *
 * Key features:
 * - Current and previous period comparison
 * - Time-series data points for detailed charting
 * - Percentage change calculation
 * - Flexible categorization and labeling
 * - Multi-unit support for different metric types
 *
 * Use cases:
 * - Revenue trend analysis (comparing this month vs last month)
 * - Transaction volume tracking over time
 * - Growth rate visualization
 * - Performance dashboards with historical comparison
 * - Business metric reporting (sales, orders, conversions, etc.)
 *
 * Example scenarios:
 * - "Revenue: $10,000 this month vs $8,000 last month (+25%)"
 * - "Orders: 500 this week vs 450 last week (+11%)"
 * - "Daily transaction volume trend over the past 30 days"
 */
public class StatsChartItem {
    /**
     * Category identifier for the chart data.
     * Groups related metrics together for organizational purposes.
     * Examples: "revenue", "transactions", "customers", "orders"
     * Used for filtering and organizing dashboard widgets.
     */
    @SerializedName("category")
    private String category;

    /**
     * Display title for the chart.
     * Human-readable label shown in dashboards and reports.
     * Examples: "Total Revenue", "Transaction Count", "Average Order Value"
     * Should be descriptive and user-friendly.
     */
    @SerializedName("title")
    private String title;

    /**
     * Time unit for the data points.
     * Defines the granularity of the time-series data.
     * Examples: "day", "week", "month", "year", "hour"
     * Determines how data points are grouped and displayed on the X-axis.
     */
    @SerializedName("unit")
    private String unit;

    /**
     * Unit for the metric values.
     * Specifies the measurement unit for the Y-axis values.
     * Examples: "USD", "count", "percentage", "ETH", "USDT"
     * Used for formatting values in charts and tooltips.
     */
    @SerializedName("value_unit")
    private String valueUnit;

    /**
     * Total aggregated value for the current period.
     * Sum or aggregate of all currentValue data points.
     * Format: String to preserve precision for financial data.
     * Example: "10000.50" for total revenue
     */
    @SerializedName("total_current_value")
    private String totalCurrentValue;

    /**
     * Total aggregated value for the previous period.
     * Sum or aggregate of all previousValue data points.
     * Used as baseline for comparison and trend analysis.
     * Format: String to preserve precision for financial data.
     * Example: "8000.00" for previous period revenue
     */
    @SerializedName("total_previous_value")
    private String totalPreviousValue;

    /**
     * Percentage change from previous to current period.
     * Calculated as: ((current - previous) / previous) * 100
     * Positive values indicate growth, negative values indicate decline.
     * Example: 25 represents +25% growth, -10 represents -10% decline
     * Useful for quick trend identification and KPI monitoring.
     */
    @SerializedName("total_percent")
    private Long totalPercent;

    /**
     * List of data points for the current period.
     * Each ValueList item contains a timestamp and value pair.
     * Points are typically ordered chronologically for time-series visualization.
     * Used to plot the current period line/bars on the chart.
     */
    @SerializedName("current_value")
    private List<ValueList> currentValue;

    /**
     * List of data points for the previous period.
     * Each ValueList item contains a timestamp and value pair.
     * Provides historical comparison baseline for trend analysis.
     * Used to plot the comparison line/bars on the chart.
     * Should have same length as currentValue for proper comparison.
     */
    @SerializedName("previous_value")
    private List<ValueList> previousValue;

    /**
     * Default constructor for StatsChartItem.
     */
    public StatsChartItem() {
    }

    /**
     * Gets the category identifier.
     * @return The category name
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the category identifier.
     * @param category The category name
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Gets the chart title.
     * @return The display title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the chart title.
     * @param title The display title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the time unit.
     * @return The time granularity unit
     */
    public String getUnit() {
        return unit;
    }

    /**
     * Sets the time unit.
     * @param unit The time granularity unit
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * Gets the value unit.
     * @return The measurement unit for values
     */
    public String getValueUnit() {
        return valueUnit;
    }

    /**
     * Sets the value unit.
     * @param valueUnit The measurement unit for values
     */
    public void setValueUnit(String valueUnit) {
        this.valueUnit = valueUnit;
    }

    /**
     * Gets the total current period value.
     * @return The aggregated current value
     */
    public String getTotalCurrentValue() {
        return totalCurrentValue;
    }

    /**
     * Sets the total current period value.
     * @param totalCurrentValue The aggregated current value
     */
    public void setTotalCurrentValue(String totalCurrentValue) {
        this.totalCurrentValue = totalCurrentValue;
    }

    /**
     * Gets the total previous period value.
     * @return The aggregated previous value
     */
    public String getTotalPreviousValue() {
        return totalPreviousValue;
    }

    /**
     * Sets the total previous period value.
     * @param totalPreviousValue The aggregated previous value
     */
    public void setTotalPreviousValue(String totalPreviousValue) {
        this.totalPreviousValue = totalPreviousValue;
    }

    /**
     * Gets the percentage change.
     * @return The growth/decline percentage
     */
    public Long getTotalPercent() {
        return totalPercent;
    }

    /**
     * Sets the percentage change.
     * @param totalPercent The growth/decline percentage
     */
    public void setTotalPercent(Long totalPercent) {
        this.totalPercent = totalPercent;
    }

    /**
     * Gets the current period data points.
     * @return List of current period values
     */
    public List<ValueList> getCurrentValue() {
        return currentValue;
    }

    /**
     * Sets the current period data points.
     * @param currentValue List of current period values
     */
    public void setCurrentValue(List<ValueList> currentValue) {
        this.currentValue = currentValue;
    }

    /**
     * Gets the previous period data points.
     * @return List of previous period values
     */
    public List<ValueList> getPreviousValue() {
        return previousValue;
    }

    /**
     * Sets the previous period data points.
     * @param previousValue List of previous period values
     */
    public void setPreviousValue(List<ValueList> previousValue) {
        this.previousValue = previousValue;
    }
}
