
package jp.co.medITrail.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.medITrail.entity.FixedText;

public interface FixedTextRepository extends JpaRepository<FixedText, Integer> {

    List<FixedText> findByDeleteFlagOrderByCategoryAscTitleAsc(Integer deleteFlag);

    FixedText findByTextIdAndDeleteFlag(Integer textId, Integer deleteFlag);
}
