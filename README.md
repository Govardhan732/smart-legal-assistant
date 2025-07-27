#  Smart Legal Assistant – AI-Powered Indian Law Section Predictor 

This project is an AI-powered assistant that helps users identify the most relevant Indian law sections (IPC, CrPC, Cyber, etc.) based on natural language legal queries.

---

##  Features

-  Predict IPC/CrPC sections from user queries using semantic search (BERT)
-  Display legal section number, title, and real-world court/arrest examples
-  Powered by Sentence-BERT (MiniLM-L6-v2)
-  JSON-based legal section database (expandable to 500+ sections)
-  Easy to use, highly accurate, customizable, and open-source

---

##  Example Usage

**User Query**:
``My wife is mentally harassing me for dowry``

**Output**:
Predicted Section: 498A
Title           : Husband or relative of husband of a woman subjecting her to cruelty
Act             : Indian Penal Code (IPC)
Description     : Whoever, being the husband or the relative of the husband of a woman, subjects such woman to cruelty shall be punished with imprisonment for a term which may extend to three years and shall also be liable to fine.
Example Case    : State vs Rajesh Kumar, 2019 — Delhi High Court ruled that persistent mental harassment by in-laws or husband demanding dowry qualifies under Section 498A IPC.
Confidence Score: 91%
