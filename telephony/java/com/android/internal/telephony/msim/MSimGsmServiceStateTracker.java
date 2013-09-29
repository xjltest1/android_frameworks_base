/*
 * Copyright (C) 2006 The Android Open Source Project
 * Copyright (c) 2011-12 Code Aurora Forum. All rights reserved.
 * Not a Contribution, Apache license notifications and license are retained
 * for attribution purposes only.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.internal.telephony.msim;

import android.telephony.MSimTelephonyManager;
import android.util.Log;

import com.android.internal.telephony.gsm.GSMPhone;
import com.android.internal.telephony.gsm.GsmServiceStateTracker;
import com.android.internal.telephony.msim.Subscription;
import com.android.internal.telephony.uicc.UiccCardApplication;
import com.android.internal.telephony.uicc.UiccController;

/**
 * {@hide}
 */
public final class MSimGsmServiceStateTracker extends GsmServiceStateTracker {

	static final String LOG_TAG = "GSM";
	static final boolean DBG = false;

	public MSimGsmServiceStateTracker(GSMPhone phone) {
		super(phone);
	}

	@Override
	protected UiccCardApplication getUiccCardApplication() {
		Subscription subscriptionData = ((MSimGSMPhone) phone)
				.getSubscriptionInfo();
		if (subscriptionData != null) {
			return mUiccController.getUiccCardApplication(
					subscriptionData.slotId, UiccController.APP_FAM_3GPP);
		}
		return null;
	}

	@Override
	public String getSystemProperty(String property, String defValue) {
		return MSimTelephonyManager.getTelephonyProperty(property,
				phone.getSubscription(), defValue);
	}

	@Override
	protected void log(String s) {
		Log.d(LOG_TAG, "[MSimGsmSST] [SUB : " + phone.getSubscription() + "] "
				+ s);
	}

	@Override
	protected void loge(String s) {
		Log.e(LOG_TAG, "[MSimGsmSST] [SUB : " + phone.getSubscription() + "] "
				+ s);
	}

	public void updateRecords() {
		onUpdateIccAvailability();
	}
}
