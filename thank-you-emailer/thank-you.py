import smtplib
from email.message import EmailMessage

file = open('gifts.csv', 'r')
lines = file.readlines()

file = open('password.txt', 'r')
password = file.readlines()

server = smtplib.SMTP_SSL('smtp.gmail.com', 465)
print('Authenticating...')
server.login('jeremylaprise163@gmail.com', password)

for i in range(10):
    for line in lines:
        name, gift, email = line.split(',')
        # print(words)
        subject = 'Thank you for the gift'
        message = "Dear " + name + ", thank you for the " + gift

        msg = EmailMessage()
        msg.set_content(message)
        msg['Subject'] = subject
        msg['From'] = 'jlaprise25@hanoverstudents.org'
        msg['To'] = email


            
        print('Sending...')
        server.send_message(msg)
        print('Message sent!')
server.quit()