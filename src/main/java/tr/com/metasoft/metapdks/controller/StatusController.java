package tr.com.metasoft.metapdks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.metasoft.metapdks.model.Status;
import tr.com.metasoft.metapdks.model.User;
import tr.com.metasoft.metapdks.service.StatusService;
import tr.com.metasoft.metapdks.service.UserService;

import java.sql.Timestamp;
import java.util.Calendar;

@RestController
//@RequestMapping(value = "/status")
public class StatusController {

    @Autowired
    UserService userService;

    @Autowired
    StatusService statusService;

    @PutMapping(value = "/add/{qrString}/{device_id}/{selectedStatus}")
    public ResponseEntity<User> addStatus(@PathVariable(value = "qrString") String qrString,
                                          @PathVariable(value = "device_id") String device_id,
                                          @PathVariable(value = "selectedStatus") Boolean selectedStatus) {

        User existUser = userService.findUserByDeviceId(device_id);

        if (existUser != null){
            writeToDb(existUser, selectedStatus);

            System.out.println(qrString);

            return ResponseEntity.ok().body(existUser);
        }
        else {
            return ResponseEntity.notFound().build();
        }

    }

    public void writeToDb(User existUser, Boolean status) {
        Status tempStatus = new Status();
        tempStatus.setDate_time(new Timestamp(Calendar.getInstance().getTimeInMillis()));
        tempStatus.setStatus(status);

        existUser.getStatuses().add(tempStatus);

        userService.save(existUser);
    }

//    public void decideConditions(String id, User existUser) {
//        List<Status> currentDateList = statusService.getByDate(id);     //get existUser's current date list
//        List<Status> checkInList = statusService.getByCheckIn(id);     //get existUser's current date check-in list
////            List<Status> orderedTimeList = statusService.getByOrderedTime(id);
////            List<Status> lessOneMinute = statusService.getByTime();
//
//        if (currentDateList.isEmpty()) {
//            writeToDb(existUser, "check-in");
//        } else {
//            for (int i = 0; i < currentDateList.size(); i++) {
//                if (currentDateList.get(i).getStatus().equals("check-in")) {
//                    writeToDb(existUser, "check-out");
//                    break;
//                }
//                if (currentDateList.get(i).getStatus().equals("check-out")) {
//                    writeToDb(existUser, "check-in");
//                    break;
//                }
//                if (i == currentDateList.size() - 1) {
//                    writeToDb(existUser, "check-in");
//                }
//            }
//        }

//    }

}
