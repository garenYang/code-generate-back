package com.chinapost.devp.generate.pojo.vo;

import com.chinapost.devp.common.pojo.vo.AbstractVO;

import java.util.List;

/**
 * 多对多实体列表对
 *
 * @author: cpit
 * @date: 2020/9/21
 */
public class MetaEntityListPairVO extends AbstractVO {

    private List<MetaMtmEntityListVO> holds;
    private List<MetaMtmEntityListVO> unholds;

    public MetaEntityListPairVO() {
    }

    public MetaEntityListPairVO(List<MetaMtmEntityListVO> holds, List<MetaMtmEntityListVO> unholds) {
        this.holds = holds;
        this.unholds = unholds;
    }

    public List<MetaMtmEntityListVO> getHolds() {
        return holds;
    }

    public void setHolds(List<MetaMtmEntityListVO> holds) {
        this.holds = holds;
    }

    public List<MetaMtmEntityListVO> getUnholds() {
        return unholds;
    }

    public void setUnholds(List<MetaMtmEntityListVO> unholds) {
        this.unholds = unholds;
    }
}
