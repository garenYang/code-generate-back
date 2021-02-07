package com.chinapost.devp.generate.web.rest.db;

import com.chinapost.devp.common.constant.ErrorCode;
import com.chinapost.devp.common.exception.RuntimeMsgException;
import com.chinapost.devp.common.pojo.resp.R;
import com.chinapost.devp.common.pojo.vo.PageVO;
import com.chinapost.devp.generate.pojo.dto.db.ProjectDbAddDTO;
import com.chinapost.devp.generate.pojo.dto.db.ProjectDbConnectionDTO;
import com.chinapost.devp.generate.pojo.dto.db.ProjectDbUpdateDTO;
import com.chinapost.devp.generate.pojo.mapper.db.ProjectDbMapper;
import com.chinapost.devp.generate.pojo.po.db.ProjectDbPO;
import com.chinapost.devp.generate.pojo.qo.db.ProjectDbQO;
import com.chinapost.devp.generate.pojo.vo.db.ProjectDbListVO;
import com.chinapost.devp.generate.pojo.vo.db.ProjectDbShowVO;
import com.chinapost.devp.generate.service.db.ProjectDbService;
import com.chinapost.devp.generate.web.AbstractController;
import com.chinapost.devp.generate.web.api.db.ProjectDbAPI;
import com.chinapost.devp.generate.web.constant.WebConst;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 【数据源配置】控制器
 *
 * @author wn
 * @date 2021/01/22
 */
@RestController
@RequestMapping(WebConst.ModulePath.DB + "/projectDb")
public class ProjectDbController extends AbstractController implements ProjectDbAPI {

    @Autowired
    private ProjectDbService projectDbService;

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public R save(@Valid @RequestBody ProjectDbAddDTO projectDbAddDTO) throws Exception {
        ProjectDbPO projectDb = projectDbService.save(projectDbAddDTO);
        return R.buildOkData(ProjectDbMapper.INSTANCE.toShowVO(projectDb));
    }

    @Override
    @PutMapping
    public R update(@Valid @RequestBody ProjectDbUpdateDTO projectDbUpdateDTO) {
        ProjectDbPO projectDb = projectDbService.update(projectDbUpdateDTO);
        return R.buildOkData(ProjectDbMapper.INSTANCE.toShowVO(projectDb));
    }

    @Override
    @GetMapping
    public R list(@Valid ProjectDbQO projectDbQO) {
        PageVO<ProjectDbListVO> page = projectDbService.list(projectDbQO);
        return R.buildOkData(page);
    }

    @Override
    @GetMapping(value = "/{id}")
    public R show(@PathVariable Long id) {
        ProjectDbShowVO projectDbShowVO = projectDbService.show(id);
        return R.buildOkData(projectDbShowVO);
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public R delete(@PathVariable Long id) {
        int count = projectDbService.delete(id);
        return R.buildOkData(count);
    }

    @Override
    @DeleteMapping
    public R deleteBatch(@RequestBody Long[] id) {
        if (ArrayUtils.isEmpty(id)) {
            throw new RuntimeMsgException(ErrorCode.PARAM_IS_NULL.getDesc());
        }
        int count = projectDbService.delete(id);
        return R.buildOkData(count);
    }


    @Override
    @PostMapping(value = "/test-connection")
    public R testConnection(@RequestBody ProjectDbConnectionDTO dbConnectionDTO) {
        int isOk = projectDbService.testConnection(dbConnectionDTO);
        return R.buildOkData(isOk);
    }

    @Override
    @PostMapping(value = "/all-tables")
    public R allTable(@RequestBody ProjectDbConnectionDTO dbConnectionDTO) {
        List<String> tables = projectDbService.allTable(dbConnectionDTO);
        return R.buildOkData(tables);
    }

    @Override
    @PostMapping(value = "/generate-ddl")
    public R generateDdl(@RequestBody ProjectDbConnectionDTO dbConnectionDTO) {
        String ddl = projectDbService.generateDdl(dbConnectionDTO);
        return R.buildOkData(ddl);
    }
}


