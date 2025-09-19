package testobjects;

import java.util.ArrayList;
import java.util.List;

public enum PromoCodes_PublicAdmin {

    SAMPLE;

    public enum Major {

        WEB("WEB - Web Order"), ASTM("ASTM - ASTM"), CS("CS - Customer Service"),
        D02("D02 - D02 NEG Program"), GTJ("GTJ - GTJ Renewal Notices"),
        JTE("JTE - JTE Renewal Notices"), MEM("MEM - Membership Applications"),
        MOU("MOU - Memo Of Understanding"), MSFM("MSFM - Member Renewal"),
        MSFM20("MSFM20 - 2020 Member Renewals"), NEW("NEW - NEW"),
        PER("PER - PERMISSION TO REPRINT"), PTP("PTP - PTP Renewals"),
        REP("REP - REPRINTS"), ROY("ROY - ROYALIEST"), SN("SN - SN Ads"),
        TPT("TPT - TPT"), UOP("UOP - UOP Orders"),
        TEST2("TEST2 - Test");

        private final String method;

        Major(String methodName) {
            method = methodName;
        }

        public String toString() {
            return this.method;
        }
    }

    public enum Minor {

        WEB("WEB - Web"), ASTM("ASTM - ASTM"), GS("GS - ASTM Golf Shirt"),
        NEG("NEG - NEG Petroleum Program"), JRNL("JRNL - Journal Renewal"),
        MEM("MEM - MEM"), MOU("MOU - MOU - PLAQUES"), IND("IND - Individual Sub"),
        INST("INST - Institutional Sub"), PTP("PTP - PTP"), REP("REP - REPRINTS"),
        NEW("NEW - New Memberships"), UOP("UOP - New And Ren Orders"),
        UNDEFINED("UNDEFINED - Undefined"), GTJ("GTJ - Geotechnical Testing"),
        JTE("JTE - Testing & Evaluation"), ORG("ORG - ORG - PLAQUES"),
        PER("PER - PERMISSION TO REPRINT"), PO("PO - Purchase Orders"),
        RN("RN - DIRECTORY RENEWALS"), ROY("ROY - ROYALTIES"),
        RPL("RPL - NO CHARGE REPLACEMENT"), SN("SN - SN"), TPT("TPT - TPT"),
        CW("CW - COMMITTEE WEEK"), MSFM("MSFM - Member Renewal"),
        RN20("RN20 - 2020 Member Renewal"),RN21("RN21 - 2021 Member Renewal"),
        CK("CK - CK"), JP("JP - John Pace");

        private final String method;

        Minor(String methodName) {
            method = methodName;
        }

        public String toString() {
            return this.method;
        }
    }

    public enum OrderChannel {

        WEB("WEB - Web"), EMAIL("EMAIL - eMail"), FAX("FAX - Fax"),
        INTERNAL("INTERNAL - Internal"), MAIL("MAIL - Mail"),
        OUTBOUND("OUTBOUND TELES - Outbound Teles"), TELEPHONE("TELEPHONE - Telephone");

        private final String method;

        OrderChannel(String methodName) {
            method = methodName;
        }

        public String toString() {
            return this.method;
        }
    }

    public List<String[]> getPossibleCombinationForTestCaseOne() {
        List<String[]> combos = new ArrayList<String[]>() {
        };
        combos.add(new String[]{Major.ASTM.toString(), Minor.ASTM.toString(), OrderChannel.EMAIL.toString()});
        combos.add(new String[]{Major.CS.toString(), Minor.CW.toString(), OrderChannel.FAX.toString()});
        combos.add(new String[]{Major.D02.toString(), Minor.NEG.toString(), OrderChannel.INTERNAL.toString()});
        combos.add(new String[]{Major.GTJ.toString(), Minor.JRNL.toString(), OrderChannel.MAIL.toString()});
        combos.add(new String[]{Major.JTE.toString(), Minor.JRNL.toString(), OrderChannel.OUTBOUND.toString()});
        combos.add(new String[]{Major.MEM.toString(), Minor.MEM.toString(), OrderChannel.TELEPHONE.toString()});
        combos.add(new String[]{Major.MOU.toString(), Minor.UNDEFINED.toString(), OrderChannel.WEB.toString()});
        combos.add(new String[]{Major.MSFM.toString(), Minor.ASTM.toString(), OrderChannel.EMAIL.toString()});
        combos.add(new String[]{Major.MSFM20.toString(), Minor.RN20.toString(), OrderChannel.FAX.toString()});
        combos.add(new String[]{Major.PER.toString(), Minor.JP.toString(), OrderChannel.MAIL.toString()});
        combos.add(new String[]{Major.ROY.toString(), Minor.JP.toString(), OrderChannel.WEB.toString()});
        return combos;
    }

    public List<String[]> getPossibleCombinationForTestCaseTwo() {
        List<String[]> combos = new ArrayList<String[]>() {
        };
        combos.add(new String[]{Major.NEW.toString(), Minor.ASTM.toString(), OrderChannel.INTERNAL.toString()});
        combos.add(new String[]{Major.PTP.toString(), Minor.PTP.toString(), OrderChannel.OUTBOUND.toString()});
        combos.add(new String[]{Major.REP.toString(), Minor.CK.toString(), OrderChannel.TELEPHONE.toString()});
        combos.add(new String[]{Major.SN.toString(), Minor.NEW.toString(), OrderChannel.EMAIL.toString()});
        combos.add(new String[]{Major.TEST2.toString(), Minor.ASTM.toString(), OrderChannel.FAX.toString()});
        combos.add(new String[]{Major.TPT.toString(), Minor.TPT.toString(), OrderChannel.INTERNAL.toString()});
        combos.add(new String[]{Major.UOP.toString(), Minor.UNDEFINED.toString(), OrderChannel.MAIL.toString()});
        combos.add(new String[]{Major.WEB.toString(), Minor.UNDEFINED.toString(), OrderChannel.OUTBOUND.toString()});
        combos.add(new String[]{Major.CS.toString(), Minor.GTJ.toString(), OrderChannel.TELEPHONE.toString()});
        return combos;
    }

    public List<String[]> getPossibleCombinationForTestCaseThree() {
        List<String[]> combos = new ArrayList<String[]>() {
        };
        combos.add(new String[]{Major.CS.toString(), Minor.JTE.toString(), OrderChannel.WEB.toString()});
        combos.add(new String[]{Major.CS.toString(), Minor.PER.toString(), OrderChannel.EMAIL.toString()});
        combos.add(new String[]{Major.SN.toString(), Minor.PO.toString(), OrderChannel.FAX.toString()});
        combos.add(new String[]{Major.CS.toString(), Minor.REP.toString(), OrderChannel.INTERNAL.toString()});
        combos.add(new String[]{Major.MEM.toString(), Minor.RN.toString(), OrderChannel.MAIL.toString()});
        combos.add(new String[]{Major.CS.toString(), Minor.ROY.toString(), OrderChannel.OUTBOUND.toString()});
        combos.add(new String[]{Major.CS.toString(), Minor.RPL.toString(), OrderChannel.TELEPHONE.toString()});
        combos.add(new String[]{Major.CS.toString(), Minor.WEB.toString(), OrderChannel.WEB.toString()});
        combos.add(new String[]{Major.MEM.toString(), Minor.MSFM.toString(), OrderChannel.EMAIL.toString()});
        combos.add(new String[]{Major.SN.toString(), Minor.SN.toString(), OrderChannel.FAX.toString()});
        return combos;
    }

    public List<String[]> getSampleCombo() {
        List<String[]> combos = new ArrayList<String[]>() {
        };
        combos.add(new String[]{Major.ASTM.toString(), "ASTM", OrderChannel.EMAIL.toString()});
        combos.add(new String[]{Major.WEB.toString(), Minor.WEB.toString(), OrderChannel.WEB.toString()});
        return combos;
    }
}
