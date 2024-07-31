package com.sudhanshu.quizapp

object Constants {
    fun getquestion(): ArrayList<QuestionModel> {
        val questionlist = ArrayList<QuestionModel>()

        val que1 = QuestionModel(
            1,
            "1.Which ministry has recently launched virtual NQAS assessment and spot food licence initiative to ensure healthcare for all ?",
            "Ministry of Women and Child Development",
            " Ministry of Health and Family Welfare",
            " Ministry of Science and Technology",
            "Ministry of Power\n",
            2
        )
        questionlist.add(que1)
        val que2 = QuestionModel(
            2,
            "2.Recently, the Central Railway has inaugurated its first-ever floating solar plant with a 10 MWp capacity in which lake of India?",
            "Lonar lake",
            "Periyar lake",
            "Venna lake",
            "Igatpuri lake",
            4
        )
        questionlist.add(que2)
        val que3 = QuestionModel(
            3,
            "Which ministry has recently developed an eSankhyiki portal?",
            "Ministry of Science and Technology",
            "Ministry of Science and Technology",
            "Ministry of Statistics and Programme Implementation",
            "Ministry of Defence",
            3
        )
        questionlist.add(que3)
        val que4 = QuestionModel(
            4,
            "4.Which is the largest lake in the world?",
            "Caspian Sea",
            "Baikal",
            "Lake Superior",
            "Ontario",
            2
        )
        questionlist.add(que4)
        val que5 = QuestionModel(
            5,
            "5. Who wrote the novel “War and Peace?",
            "Anton Chekhov",
            "Fyodor Dostoevsky",
            "Leo Tolstoy",
            "Ivan Turgenev",
            3
        )
        questionlist.add(que5)
        val que6 = QuestionModel(
            6,
            "6. Which river is the longest in the world?",
            "Amazon",
            "Mississippi",
            "Nile",
            "Yangtze",
            3
        )
        questionlist.add(que6)
        val que7 = QuestionModel(
            7,
            "7.For which Galileo is famous?",
            "Developed the telescope",
            "Discovered four satellites of Jupiter",
            "Found that the swinging motion of the pendulum results in consistent time measurement.",
            "All of the above",
            4
        )
        questionlist.add(que7)
        val que8 = QuestionModel(
            8,
            "8.Which is the largest island?",
            "New Guinea",
            "Andaman Nicobar",
            "Greenland",
            "Hawaii",
            3
        )
        questionlist.add(que8)
        val que9 = QuestionModel(
            9,
            "9.In which century the Mona Lisa was painted?",
            "18th century",
            "15th century",
            "16th century",
            "14th century",
            3
        )
        questionlist.add(que9)
        val que10 = QuestionModel(
            10,
            "10.When the humans use more facial muscles?",
            "While smiling",
            "While frowning",
            "While sleeping",
            "While talking",
            2
        )
        questionlist.add(que10)

    return questionlist
    }
}

