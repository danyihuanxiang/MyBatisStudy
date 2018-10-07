package mybatisone.study;

import com.study.domain.School;


public interface SchoolMapper {

      School selectByPrimaryKey(Integer schoolid);

}