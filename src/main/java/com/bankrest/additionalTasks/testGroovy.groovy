package com.bankrest.additionalTasks


def system = "cmd /c "
def com = " git clone https://github.com/DarkSide2018/wildflyApp.git"
def command = system + com
def proc = command.execute()

println proc.text

def a = "ghgh "

def b = "asas"


println(a + b)