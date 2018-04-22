/*
 * Copyright (C) 2018 xuexiangjys(xuexiangjys@163.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.xuexiang.xaopdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.xuexiang.xaop.annotation.DebugLog;
import com.xuexiang.xaop.annotation.Permission;
import com.xuexiang.xaop.annotation.SingleClick;
import com.xuexiang.xaop.consts.PermissionConsts;
import com.xuexiang.xaop.logger.XLogger;
import com.xuexiang.xutil.common.logger.Logger;
import com.xuexiang.xutil.tip.ToastUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btn_single_click:
                handleOnClick(v);
                break;
            case R.id.btn_request_permission:
                handleRequestPermission(v);
                break;
            default:
                break;
        }
    }

    @SingleClick
    @Permission({PermissionConsts.CALENDAR, PermissionConsts.CAMERA, PermissionConsts.LOCATION})
    private void handleRequestPermission(View v) {

    }

    @SingleClick(5000)
    public void handleOnClick(View v) {
        XLogger.e("点击响应！");
        ToastUtil.get().toast("点击响应！");
        hello("xuexiangjys", "666666");
    }


    @DebugLog(priority = Log.ERROR)
    private String hello(String name, String cardId) {
        return "hello, " + name + "! Your CardId is " + cardId + ".";
    }
}
