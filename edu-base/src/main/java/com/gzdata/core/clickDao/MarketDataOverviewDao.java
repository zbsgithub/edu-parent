package com.gzdata.core.clickDao;/*package com.gzdata.core.clickDao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface MarketDataOverviewDao {

	@Select({"<script>"," select toFloat64(sum(inventory)) as scale_n from analytics.sample_inventory_02_01_all where personal_attribute = #{familyType} and formatDateTime(business_dt,'%Y-%m') = #{month};","</script>"})
	Integer findDataOverView(@Param("familyType")  String familyType,@Param("month")  String month);
}
*/