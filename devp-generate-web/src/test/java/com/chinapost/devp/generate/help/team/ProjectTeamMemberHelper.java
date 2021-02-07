package com.chinapost.devp.generate.help.team;

import com.chinapost.devp.generate.pojo.dto.team.ProjectTeamMemberAddDTO;
import com.chinapost.devp.generate.pojo.po.team.ProjectTeamMemberPO;
import com.chinapost.devp.generate.service.team.ProjectTeamMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.chinapost.devp.generate.pojo.example.team.ProjectTeamMemberExample.E_USERNAME;

@Component
public class ProjectTeamMemberHelper {

    @Autowired
    private ProjectTeamMemberService projectTeamMemberService;

    /**
     * 生成add测试数据
     * @return
     */
    public ProjectTeamMemberAddDTO getProjectTeamMemberAddDTO(Integer teamId){
        ProjectTeamMemberAddDTO dto = new ProjectTeamMemberAddDTO();
        dto.setTeamId(teamId);
        dto.setUsername(E_USERNAME);
        return dto;
    }

    /**
     * 保存示例
     * @return
     */
    public ProjectTeamMemberPO saveProjectTeamMemberExample(Integer teamId){
        return projectTeamMemberService.save(teamId, E_USERNAME);
    }

}

