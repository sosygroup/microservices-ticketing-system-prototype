
instance_dict = dict()

with(open("../logs/customer.log", encoding="UTF-8", mode="r")) as logfile:

    for line in logfile:
        if "i.u.s.t.p.c.service.CustomerService" in line:
            splitted = line.split(" Choreography Instance ")[1].split(" ")
            instance = splitted[0].strip(":")
            direction = splitted[1]
            operation = splitted[2]
            timestamp = splitted[4]

            if (instance, operation) in instance_dict:
                instance_dict[(instance, operation)].append((direction, timestamp))
            else:
                instance_dict[(instance, operation)] = [(direction, timestamp)]

instance_times_dict = dict()

for (instance, operation) in instance_dict:
    exec_time = 0
    times = instance_dict[(instance, operation)]
    for (direction, timestamp) in times:
        if direction == 'Sending':
            exec_time -= int(timestamp)
        elif direction == 'Received':
            exec_time += int(timestamp)
    if instance in instance_times_dict:
        instance_times_dict[instance].append((operation, exec_time))
    else:
        instance_times_dict[instance] = [(operation, exec_time)]

with(open("../results/results.csv", encoding="UTF-8", mode="w")) as csvfile:
    op_order = {"getEventList": 0, "getEventInfo": 1, "ticketSelection": 2, "checkoutProcess": 3}

    csvfile.write("InstanceId,getEventList,getEventInfo,ticketSelection,checkoutProcess\n")
    for instance in instance_times_dict:
        data_array = [0]*4
        for (operation, exec_time) in instance_times_dict[instance]:
            data_array[op_order[operation]] = exec_time
        csvfile.write(instance+","+str(data_array[0])+","+str(data_array[1])+","+str(data_array[2])+","+str(data_array[3])+"\n")
