from tkinter import *
import bondhon

class calendar:
    def __init__(self, root):
        self.root = root
        self.root.title("বাংলা পঁজিকা")
        self.root.geometry("700x600")
        self.frame = Frame(self.root)
        self.frame.pack()
        print(bondhon.convert('utf-8', 'bijoy', 'বৈশাখ'))

        label = Label(self.root, text="১", font=("Lohit Bengali", 16))
        label.place(x=500,y=0)

        rbutton =Button(self.frame, text=">", )
        rbutton.pack(side=RIGHT)
        lbutton =Button(self.frame, text=">", )
        lbutton.pack(side=LEFT)




def main():
    root = Tk()
    app = calendar(root)
    root.mainloop()

if __name__ == '__main__':
    main()
