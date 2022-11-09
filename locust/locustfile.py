import random
import string
from locust import SequentialTaskSet, FastHttpUser, task, between


class UserTaskSequence(SequentialTaskSet):
    user_id = ''

    @task
    def invoke_get_events_list(self):
        self.client.get(f"/customer/invokeGetEventsList/{self.user_id}")

    @task
    def invoke_get_event_info(self):
        self.client.get(f"/customer/invokeGetEventInfo/{self.user_id}")

    @task
    def invoke_select_tickets(self):
        self.client.get(f"/customer/invokeSelectTickets/{self.user_id}")

    @task
    def invoke_request_checkout(self):
        self.client.get(f"/customer/invokeRequestCheckout/{self.user_id}")

    def on_start(self):
        self.user_id = ''.join(random.choice(string.ascii_uppercase + string.digits) for _ in range(10))


class TicketServiceUser(FastHttpUser):
    tasks = [UserTaskSequence]
    wait_time = between(5, 10)
