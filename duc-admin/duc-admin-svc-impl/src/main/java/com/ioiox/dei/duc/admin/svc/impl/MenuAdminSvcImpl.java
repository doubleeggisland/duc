package com.ioiox.dei.duc.admin.svc.impl;

import com.ioiox.dei.duc.admin.svc.api.MenuAdminSvc;
import com.ioiox.dei.rest.api.clients.DucsRestApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("menuAdminSvc")
public class MenuAdminSvcImpl
        implements MenuAdminSvc {

    @Autowired
    private DucsRestApiClient ducsRestApiClient;


}
